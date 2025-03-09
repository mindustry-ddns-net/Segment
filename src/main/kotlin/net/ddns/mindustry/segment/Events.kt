package net.ddns.mindustry.segment

import arc.Events
import mindustry.game.EventType
import mindustry.game.EventType.TextInputEvent
import mindustry.gen.Player
import mindustry.net.Administration

fun loadEvents() {
    Events.on(TextInputEvent::class.java) { e -> playerTextInputResponse(e) }

    if (Administration.Config.debug.bool()) {
        Events.on(EventType.PlayerJoin::class.java) { e ->
            val textInput = TextInput(e.player, "lorem ipsum", "dolor sit amet", ::testCallback)
            textInput.show()
        }
    }
}

private fun playerTextInputResponse(event: TextInputEvent) {
    textInputHandler.executeCallback(event.player, event.text)
    textInputHandler.removeTextInput(event.player)
}

private fun testCallback(player: Player, text: String) {
    player.sendMessage("You typed in: $text")
}
