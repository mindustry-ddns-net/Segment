package net.ddns.mindustry.segment.ui.menu

import arc.Events
import mindustry.game.EventType
import mindustry.gen.Player
import net.ddns.mindustry.segment.ui.Child
import net.ddns.mindustry.segment.ui.UIHandler

class MenuHandler : UIHandler<BaseMenu>() {
    override var children: MutableMap<Int, BaseMenu> = mutableMapOf()

    init {
        Events.on(EventType.MenuOptionChooseEvent::class.java, ::menuInputEvent)
    }

    fun addMenu(
        title: String,
        message: String,
        options: Array<Array<String>>,
        callback: (Player, Array<String>, Child) -> Unit
    ): BaseMenu {
        val id = generateID()
        val menu = BaseMenu(
            title,
            message,
            id,
            options,
            -1, // no option selected yet
            callback
        )

        children[id] = menu
        return menu
    }

    private fun menuInputEvent(event: EventType.MenuOptionChooseEvent) {
        this.children[event.menuId]!!.option = event.option
        this.executeCallback(event.menuId, event.player)
        this.removeChild(event.menuId)
    }
}
