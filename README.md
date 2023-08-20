# Origamikings-API

This is an API mod that my mods use. This mod will not change gameplay. This mod will be embedded in most of my mods

## List of mods that use this API/Library Mod

- [OrigamiKings Enhancement Mod](https://modrinth.com/mod/origamikings-enhancement-mod)
- [OrigamiKings Robotics Armor Mod](https://modrinth.com/mod/origamikings-robotics-armor-mod)

## How to use this API/Library Mod

### Add this to your `gradle.properties`

The `version_id` is found on [Modrinth](https://modrinth.com/mod/origamikings-api/versions)

```gradle
origamikings_api=(version_id)
```

### Add this to your `build.gradle`

 ```gradle
 repositories {
    maven {
       name = "Modrinth"
       url = "https://api.modrinth.com/maven"
    }
}
dependencies {
    modImplementation "maven.modrinth:P3sjMa3U:${origamikings_api}"
}
 ```

[//]: # (Set<String> apiModules = [)

[//]: # ("fabric-api-base",)

[//]: # ("fabric-api-lookup-api-v1",)

[//]: # ("fabric-biome-api-v1",)

[//]: # ("fabric-block-api-v1",)

[//]: # ("fabric-blockrenderlayer-v1",)

[//]: # ("fabric-client-tags-api-v1",)

[//]: # ("fabric-command-api-v2",)

[//]: # ("fabric-content-registries-v0",)

[//]: # ("fabric-convention-tags-v1",)

[//]: # ("fabric-crash-report-info-v1",)

[//]: # ("fabric-dimensions-v1",)

[//]: # ("fabric-entity-events-v1",)

[//]: # ("fabric-events-interaction-v0",)

[//]: # ("fabric-game-rule-api-v1",)

[//]: # ("fabric-gametest-api-v1",)

[//]: # ("fabric-item-api-v1",)

[//]: # ("fabric-item-group-api-v1",)

[//]: # ("fabric-key-binding-api-v1",)

[//]: # ("fabric-lifecycle-events-v1",)

[//]: # ("fabric-loot-api-v2",)

[//]: # ("fabric-message-api-v1",)

[//]: # ("fabric-mining-level-api-v1",)

[//]: # ("fabric-model-loading-api-v1",)

[//]: # ("fabric-networking-api-v1",)

[//]: # ("fabric-object-builder-api-v1",)

[//]: # ("fabric-particles-v1",)

[//]: # ("fabric-recipe-api-v1",)

[//]: # ("fabric-registry-sync-v0",)

[//]: # ("fabric-renderer-api-v1",)

[//]: # ("fabric-renderer-indigo",)

[//]: # ("fabric-rendering-data-attachment-v1",)

[//]: # ("fabric-rendering-fluids-v1",)

[//]: # ("fabric-rendering-v1",)

[//]: # ("fabric-resource-conditions-api-v1",)

[//]: # ("fabric-resource-loader-v0",)

[//]: # ("fabric-screen-api-v1",)

[//]: # ("fabric-screen-handler-api-v1",)

[//]: # ("fabric-sound-api-v1",)

[//]: # ("fabric-transfer-api-v1",)

[//]: # ("fabric-transitive-access-wideners-v1")

[//]: # (])
