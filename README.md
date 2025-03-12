# Segment
[![](https://jitpack.io/v/mindustry-ddns-net/segment.svg)](https://jitpack.io/#mindustry-ddns-net/segment)
[![Mindustry 7.0](https://img.shields.io/badge/Mindustry-7.0-00ced1)](https://github.com/Anuken/Mindustry/releases)

![img.png](media/segment.png) \
*([not my image](https://github.com/Anuken/Mindustry/blob/fd597080a692c816d9cc7c4aba2973762bdd1a30/core/assets-raw/sprites/blocks/defense/segment.png) btw)* \
A Mindustry plugin framework that makes it easier to handle text inputs rather than using Anuke's icky `Call.textInput`.

# Installation
## Supports
[x] Headed server \
[x] Headless server \
[ ] Client

## Headless server
Download the latest jar from releases and cut/copy it into your server's mod directory. This is usually located in 
`{server_root}/config/mods`. If you cannot find the `config/mods` folder, then you may need to start the server. If you
still can't find it, then it's within your best interest to get external help.

# Usage
Use `[TextInputHandler object].addTextInput()` (excludes parameters) to create a new text input. Use 
`[TextInputHandler object].addTextInput().show()` (excludes parameters) to create a new text input and show it. 
Alternatively, you can create a new `TextInput` object and provide a `TextInputHandler` object as a parameter. Below is
an example:
```kotlin
private var textInputHandler = TextInputHandler()

fun loadEvents() {
    Events.on(EventType.PlayerJoin::class.java) { e ->
        val textInput = TextInput(e.player, "lorem ipsum", "dolor sit amet", ::exampleCallback, textInputHandler)
        textInput.show()
    }
}

private fun exampleCallback(player: Player, text: String) {
    player.sendMessage("You typed in: $text")
}
```
