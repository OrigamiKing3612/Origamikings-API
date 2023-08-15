/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 * Copyright (c) 2023 OrigamiKing3612
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.origamiking.mcmods.oapi.mixin.origami_datagen.server;

import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;
import net.minecraft.server.Main;
import net.origamiking.mcmods.oapi.oapi_datagen.impl.OrigamiDataGenHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(Main.class)
public class MainMixin {
	@Inject(method = "main", at = @At(value = "NEW", target = "net/minecraft/server/dedicated/ServerPropertiesLoader"), cancellable = true)
	private static void main(String[] args, CallbackInfo info) throws IOException {
		if (OrigamiDataGenHelper.ENABLED) {
			OrigamiDataGenHelper.run();
			if (FabricDataGenHelper.ENABLED) {
				FabricDataGenHelper.run();
			}
			info.cancel();
		}
	}
}
