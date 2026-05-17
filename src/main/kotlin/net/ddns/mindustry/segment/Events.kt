package net.ddns.mindustry.segment

import arc.Events
import mindustry.game.EventType
import mindustry.gen.Player
import net.ddns.mindustry.segment.ui.Child
import net.ddns.mindustry.segment.ui.menu.BaseMenu
import net.ddns.mindustry.segment.ui.textInput.BaseTextInput
import net.ddns.mindustry.segment.ui.textInput.TextInput

fun loadEvents() {
//    Events.on(TextInputEvent::class.java) { e -> playerTextInputResponse(e) }

    if (testingConfig!!.bool()) {
        Events.on(EventType.PlayerJoin::class.java) { e ->
//            val menu = BaseMenu("Lorem", "Ipsum", 10000, arrayOf(arrayOf("Lorem", "Ipsum"), arrayOf("Dolor", "Sit")), ::testCallback)

            val menu = menuHandler.addMenu("Title", "lorem ipsum dolor sit amet",
                arrayOf(arrayOf("Lorem", "ipsum"), arrayOf("Dolor", "sit"), arrayOf("Amet")),
                ::menuCallback
            )
            menu.show()

//            val textInput = TextInput(e.player, "lorem ipsum", "dolor sit amet", ::testCallback,
//                textInputHandler)
//            textInput.show()
        }
    }
}

//private fun playerTextInputResponse(event: TextInputEvent) {
//    textInputHandler.executeCallback(event.textInputId, event.player, event.text)
//    textInputHandler.removeTextInput(event.textInputId)
//}

private fun testCallback(player: Player, args: Array<String>, child: Child) {
    if (child !is BaseTextInput) {
        return
    }

    player.sendMessage("You typed in: ${child.text}")
}

private fun menuCallback(player: Player, args: Array<String>, child: Child) {
    if (child !is BaseMenu) {
        return
    }

    player.sendMessage(child.option.toString())
}
