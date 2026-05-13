package net.ddns.mindustry.segment

import arc.Events
import mindustry.game.EventType
import mindustry.gen.Player
import net.ddns.mindustry.segment.ui.textInput.TextInput

fun loadEvents() {
//    Events.on(TextInputEvent::class.java) { e -> playerTextInputResponse(e) }

    if (testingConfig!!.bool()) {
        Events.on(EventType.PlayerJoin::class.java) { e ->
            val textInput = TextInput(e.player, "lorem ipsum", "dolor sit amet", ::testCallback,
                textInputHandler)
            textInput.show()
        }
    }
}

//private fun playerTextInputResponse(event: TextInputEvent) {
//    textInputHandler.executeCallback(event.textInputId, event.player, event.text)
//    textInputHandler.removeTextInput(event.textInputId)
//}

private fun testCallback(player: Player, text: String?, args: Array<String>) {
    player.sendMessage("You typed in: $text")
}
