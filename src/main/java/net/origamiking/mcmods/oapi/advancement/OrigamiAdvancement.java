package net.origamiking.mcmods.oapi.advancement;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrigamiAdvancement extends Advancement {

    public OrigamiAdvancement(Identifier id, @Nullable Advancement parent, @Nullable AdvancementDisplay display, AdvancementRewards rewards, Map<String, AdvancementCriterion> criteria, String[][] requirements, boolean sendsTelemetryEvent) {
        super(id, parent, display, rewards, criteria, requirements, sendsTelemetryEvent);
    }
    public static class Builder {
        @Nullable
        private Identifier parentId;
        @Nullable
        private OrigamiAdvancement parentObj;
        @Nullable
        private AdvancementDisplay display;
        private AdvancementRewards rewards = AdvancementRewards.NONE;
        private Map<String, AdvancementCriterion> criteria = Maps.newLinkedHashMap();
        @Nullable
        private String[][] requirements;
        private CriterionMerger merger = CriterionMerger.AND;
        private final boolean sendsTelemetryEvent;

        Builder(@Nullable Identifier parentId, @Nullable AdvancementDisplay display, AdvancementRewards rewards, Map<String, AdvancementCriterion> criteria, String[][] requirements, boolean sendsTelemetryEvent) {
            this.parentId = parentId;
            this.display = display;
            this.rewards = rewards;
            this.criteria = criteria;
            this.requirements = requirements;
            this.sendsTelemetryEvent = sendsTelemetryEvent;
        }

        private Builder(boolean sendsTelemetryEvent) {
            this.sendsTelemetryEvent = sendsTelemetryEvent;
        }

        public static Builder create() {
            return new Builder(true);
        }

        public static Builder createUntelemetered() {
            return new Builder(false);
        }

        public Builder parent(OrigamiAdvancement parent) {
            this.parentObj = parent;
            return this;
        }

        public Builder parent(Identifier parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder display(ItemStack icon, Text title, Text description, @Nullable Identifier background, AdvancementFrame frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return this.display(new AdvancementDisplay(icon, title, description, background, frame, showToast, announceToChat, hidden));
        }

        public Builder display(ItemConvertible icon, Text title, Text description, @Nullable Identifier background, AdvancementFrame frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return this.display(new AdvancementDisplay(new ItemStack(icon.asItem()), title, description, background, frame, showToast, announceToChat, hidden));
        }

        public Builder display(AdvancementDisplay display) {
            this.display = display;
            return this;
        }

        public Builder rewards(AdvancementRewards.Builder builder) {
            return this.rewards(builder.build());
        }

        public Builder rewards(AdvancementRewards rewards) {
            this.rewards = rewards;
            return this;
        }

        public Builder criterion(String name, CriterionConditions conditions) {
            return this.criterion(name, new AdvancementCriterion(conditions));
        }

        public Builder criterion(String name, AdvancementCriterion criterion) {
            if (this.criteria.containsKey(name)) {
                throw new IllegalArgumentException("Duplicate criterion " + name);
            }
            this.criteria.put(name, criterion);
            return this;
        }

        public Builder criteriaMerger(CriterionMerger merger) {
            this.merger = merger;
            return this;
        }

        public Builder requirements(String[][] requirements) {
            this.requirements = requirements;
            return this;
        }

        public boolean findParent(Function<Identifier, OrigamiAdvancement> parentProvider) {
            if (this.parentId == null) {
                return true;
            }
            if (this.parentObj == null) {
                this.parentObj = parentProvider.apply(this.parentId);
            }
            return this.parentObj != null;
        }

        public OrigamiAdvancement build(Identifier id) {
            if (!this.findParent(idx -> null)) {
                throw new IllegalStateException("Tried to build incomplete advancement!");
            }
            if (this.requirements == null) {
                this.requirements = this.merger.createRequirements(this.criteria.keySet());
            }
            return new OrigamiAdvancement(id, this.parentObj, this.display, this.rewards, this.criteria, this.requirements, this.sendsTelemetryEvent);
        }

        public OrigamiAdvancement build(Consumer<OrigamiAdvancement> exporter, String modid, String id) {
            OrigamiAdvancement advancement = this.build(new Identifier(modid, id));
            exporter.accept(advancement);
            return advancement;
        }

        public JsonObject toJson() {
            if (this.requirements == null) {
                this.requirements = this.merger.createRequirements(this.criteria.keySet());
            }
            JsonObject jsonObject = new JsonObject();
            if (this.parentObj != null) {
                jsonObject.addProperty("parent", this.parentObj.getId().toString());
            } else if (this.parentId != null) {
                jsonObject.addProperty("parent", this.parentId.toString());
            }
            if (this.display != null) {
                jsonObject.add("display", this.display.toJson());
            }
            jsonObject.add("rewards", this.rewards.toJson());
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry<String, AdvancementCriterion> entry : this.criteria.entrySet()) {
                jsonObject2.add(entry.getKey(), entry.getValue().toJson());
            }
            jsonObject.add("criteria", jsonObject2);
            JsonArray jsonArray = new JsonArray();
            for (String[] strings : this.requirements) {
                JsonArray jsonArray2 = new JsonArray();
                for (String string : strings) {
                    jsonArray2.add(string);
                }
                jsonArray.add(jsonArray2);
            }
            jsonObject.add("requirements", jsonArray);
            jsonObject.addProperty("sends_telemetry_event", this.sendsTelemetryEvent);
            return jsonObject;
        }

        public void toPacket(PacketByteBuf buf) {
            if (this.requirements == null) {
                this.requirements = this.merger.createRequirements(this.criteria.keySet());
            }
            buf.writeNullable(this.parentId, PacketByteBuf::writeIdentifier);
            buf.writeNullable(this.display, (buf2, display) -> display.toPacket((PacketByteBuf)buf2));
            AdvancementCriterion.criteriaToPacket(this.criteria, buf);
            buf.writeVarInt(this.requirements.length);
            for (String[] strings : this.requirements) {
                buf.writeVarInt(strings.length);
                for (String string : strings) {
                    buf.writeString(string);
                }
            }
            buf.writeBoolean(this.sendsTelemetryEvent);
        }

        public String toString() {
            return "Task Advancement{parentId=" + this.parentId + ", display=" + this.display + ", rewards=" + this.rewards + ", criteria=" + this.criteria + ", requirements=" + Arrays.deepToString((Object[])this.requirements) + ", sends_telemetry_event=" + this.sendsTelemetryEvent + "}";
        }

        public static Builder fromJson(JsonObject obj, AdvancementEntityPredicateDeserializer predicateDeserializer) {
            int i;
            Identifier identifier = obj.has("parent") ? new Identifier(JsonHelper.getString(obj, "parent")) : null;
            AdvancementDisplay advancementDisplay = obj.has("display") ? AdvancementDisplay.fromJson(JsonHelper.getObject(obj, "display")) : null;
            AdvancementRewards advancementRewards = obj.has("rewards") ? AdvancementRewards.fromJson(JsonHelper.getObject(obj, "rewards")) : AdvancementRewards.NONE;
            Map<String, AdvancementCriterion> map = AdvancementCriterion.criteriaFromJson(JsonHelper.getObject(obj, "criteria"), predicateDeserializer);
            if (map.isEmpty()) {
                throw new JsonSyntaxException("Advancement criteria cannot be empty");
            }
            JsonArray jsonArray = JsonHelper.getArray(obj, "requirements", new JsonArray());
            String[][] strings = new String[jsonArray.size()][];
            for (i = 0; i < jsonArray.size(); ++i) {
                JsonArray jsonArray2 = JsonHelper.asArray(jsonArray.get(i), "requirements[" + i + "]");
                strings[i] = new String[jsonArray2.size()];
                for (int j = 0; j < jsonArray2.size(); ++j) {
                    strings[i][j] = JsonHelper.asString(jsonArray2.get(j), "requirements[" + i + "][" + j + "]");
                }
            }
            if (strings.length == 0) {
                strings = new String[map.size()][];
                i = 0;
                for (String string : map.keySet()) {
                    strings[i++] = new String[]{string};
                }
            }
            for (String[] strings2 : strings) {
                if (strings2.length == 0 && map.isEmpty()) {
                    throw new JsonSyntaxException("Requirement entry cannot be empty");
                }
                String[] stringArray = strings2;
                int n = stringArray.length;
                for (int j = 0; j < n; ++j) {
                    String string2 = stringArray[j];
                    if (map.containsKey(string2)) continue;
                    throw new JsonSyntaxException("Unknown required criterion '" + string2 + "'");
                }
            }
            for (String string3 : map.keySet()) {
                boolean bl = false;
                for (Object[] objectArray : strings) {
                    if (!ArrayUtils.contains(objectArray, string3)) continue;
                    bl = true;
                    break;
                }
                if (bl) continue;
                throw new JsonSyntaxException("Criterion '" + string3 + "' isn't a requirement for completion. This isn't supported behaviour, all criteria must be required.");
            }
            boolean bl2 = JsonHelper.getBoolean(obj, "sends_telemetry_event", false);
            return new Builder(identifier, advancementDisplay, advancementRewards, map, strings, bl2);
        }

        public static Builder fromPacket(PacketByteBuf buf) {
            Identifier identifier = (Identifier)buf.readNullable(PacketByteBuf::readIdentifier);
            AdvancementDisplay advancementDisplay = (AdvancementDisplay)buf.readNullable(AdvancementDisplay::fromPacket);
            Map<String, AdvancementCriterion> map = AdvancementCriterion.criteriaFromPacket(buf);
            String[][] strings = new String[buf.readVarInt()][];
            for (int i = 0; i < strings.length; ++i) {
                strings[i] = new String[buf.readVarInt()];
                for (int j = 0; j < strings[i].length; ++j) {
                    strings[i][j] = buf.readString();
                }
            }
            boolean bl = buf.readBoolean();
            return new Builder(identifier, advancementDisplay, AdvancementRewards.NONE, map, strings, bl);
        }

        public Map<String, AdvancementCriterion> getCriteria() {
            return this.criteria;
        }
    }
}
