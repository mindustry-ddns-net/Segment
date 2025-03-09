# Segment
([not my image](https://github.com/Anuken/Mindustry/blob/fd597080a692c816d9cc7c4aba2973762bdd1a30/core/assets-raw/sprites/blocks/defense/segment.png) btw) \
![img.png](media/segment.png) \
A Mindustry plugin framework that makes it easier to handle text inputs rather than using Anuke's icky `Call.textInput`.

# Installation
## Headless server
Download the latest jar from releases and cut/copy it into your server's mod directory. This is usually located in 
`{server_root}/config/mods`. If you cannot find the `config/mods` folder, then you may need to start the server. If you
still can't find it, then it's within your best interest to get external help.

## Headed server
This isn't intended for a headed server, so I won't bother with writing out instructions for this. (It's not that I hate
 this project, I just do not like writing documentation in a `README.md`)

# Usage
Use `textInputHandler.addTextInput()` to create a new text input. Use `textInputHandler.addTextInput().show()` to create
a new text input and show it. Keep in mind that both of those don't account for parameters. Below is a proper example 
in Kotlin:
```kotlin
fun loadEvents() {
    Events.on(EventType.PlayerJoin::class.java) { e ->
        val textInput = TextInput(e.player, "lorem ipsum", "dolor sit amet", ::exampleCallback)
        textInput.show()
    }
}

private fun exampleCallback(player: Player, text: String) {
    player.sendMessage("You typed in: $text")
}
```
It'll be a little different for Java, but it shouldn't stray far off.
