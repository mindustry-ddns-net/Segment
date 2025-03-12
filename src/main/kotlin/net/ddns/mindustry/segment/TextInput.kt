package net.ddns.mindustry.segment

import mindustry.gen.Player

class TextInput(
    private val player: Player, title: String, message: String, callback: (player: Player, text: String?) -> Unit,
    inputHandler: TextInputHandler, charCount: Int = 1024, default: String = "", numeric: Boolean = false) {

    private var textInput: BaseTextInput =
        inputHandler.addTextInput(title, message, callback, charCount, default, numeric)

    /**
     * Shows the text input to the player.
     */
    fun show() {
        textInput.show(player.con())
    }
}