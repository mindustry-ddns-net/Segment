package net.ddns.mindustry.segment

import mindustry.gen.Player

class TextInput(
    private val player: Player, title: String, message: String, callback: (player: Player, text: String?) -> Unit,
    charCount: Int = 1024, default: String = "", numeric: Boolean = false,
    inputHandler: TextInputHandler = textInputHandler) {

    private var textInput: BaseTextInput =
        inputHandler.addTextInput(player, title, message, callback, charCount, default, numeric)

    /**
     * Shows the text input to the player.
     */
    fun show() {
        textInput.show(player.con())
    }
}