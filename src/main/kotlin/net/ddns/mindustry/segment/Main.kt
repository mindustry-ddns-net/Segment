package net.ddns.mindustry.segment

import arc.util.CommandHandler
import mindustry.mod.Plugin
import net.ddns.mindustry.segment.ui.menu.MenuHandler
import net.ddns.mindustry.segment.ui.textInput.TextInputHandler

val textInputHandler = TextInputHandler()
val menuHandler = MenuHandler()

@Suppress("unused") // it is used, just not in this project
class Main : Plugin() {
    companion object {
        fun getTextInputHandler(): TextInputHandler {
            return textInputHandler
        }
    }

    override fun init() {
        loadConfigs()
        loadEvents()
    }

    override fun registerClientCommands(handler: CommandHandler?) {

    }

    override fun registerServerCommands(handler: CommandHandler?) {

    }
}