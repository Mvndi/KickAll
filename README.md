[download]: https://img.shields.io/github/downloads/Mvndi/KickAll/total
[downloadLink]: https://hangar.papermc.io/Hydrolien/KickAll
[discord-shield]: https://img.shields.io/discord/728592434577014825?label=discord
[discord-invite]: https://discord.gg/RPNbtRSFqG

[ ![download][] ][downloadLink]
[ ![discord-shield][] ][discord-invite]

[**Discord**](https://discord.gg/RPNbtRSFqG) | [**Modrinth**](https://modrinth.com/plugin/kickall) | [**Hangar**](https://hangar.papermc.io/Hydrolien/KickAll) | [**GitHub**](https://github.com/Mvndi/KickAll)

# KickAll

A simple kick all players command compatible with Paper, Folia and other paper forks.

This plugin achieve a simple task: Kick all players from a server.
Some plugins already move player from a server to an other server, but I coudn't found a server where it use `player.kick()`. Kicking the players trigger `PlayerQuitEvent`s with `KICKED` as `QuitReason`. This specific quit reason can be used to avoid killing players if in combat with an anti combat loggout since they didn't leave the server on their own but were kicked by an admin.

This plugin might become obsolete in a future Minecraft version, if the ability to kick all player is added to Paper. I think it should be a command for all servers.

Give `kickall.admin` permission to use the `/kickall` command.

## Statistics
[![bStats Graph Data](https://bstats.org/signatures/bukkit/KickAll.svg)](https://bstats.org/plugin/bukkit/KickAll/31780)

# Build, Test & deploy

Feature requests or pull requests are welcome. Concider creating an issue first to talk about your new feature before sending a pull request.

## Build

Clone the [repo](https://github.com/Mvndi/KickAll) `git clone git@github.com:Mvndi/KickAll.git`

Build with `./gradlew assemble`. The plugin .jar file will be in `build/libs/`.

## Test

You can test the plugin directly in a Minecraft server with `./gradlew runServer`.
You can also try it on an other server by placing the .jar in `plugins/`.
You might want to update the plugin config to fit your needs.

## Deploy

### To Github releases, Hangar & Modrinth

Push tag to git to trigger a github action release that will create a new Github release and publish to Hangar & Modrinth.
```sh
git tag 1.2.3
git push --tags
```

### to Maven central

*Require ossrhUsername & ossrhPassword in ~/.gradle/gradle.properties*

```sh
./gradlew clean publish
./gradlew jreleaserDeploy
```
The published lib will be available [on maven central](https://central.sonatype.com/artifact/net.mvndicraft.kickall/kickall).