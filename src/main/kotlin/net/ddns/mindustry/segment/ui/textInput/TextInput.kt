package net.ddns.mindustry.segment.ui.textInput

import mindustry.gen.Player
import net.ddns.mindustry.segment.ui.Child

class TextInput(
    private val player: Player, title: String, message: String,
    callback: (player: Player, Child) -> Unit, inputHandler: TextInputHandler,
    charCount: Int = 1024, default: String = "", numeric: Boolean = false, args: Array<String> = arrayOf()) {

    private var textInput: BaseTextInput =
        inputHandler.addTextInput(title, message, callback, charCount, default, numeric)

    /**
     * Shows the text input to the player.
     */
    fun show() {
        textInput.show(player.con())
    }
}