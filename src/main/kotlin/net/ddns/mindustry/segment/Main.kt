package net.ddns.mindustry.segment

import arc.util.CommandHandler
import mindustry.mod.Plugin

val textInputHandler = TextInputHandler()

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