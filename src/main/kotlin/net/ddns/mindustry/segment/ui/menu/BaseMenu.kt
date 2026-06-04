package net.ddns.mindustry.segment.ui.menu

import mindustry.gen.Call
import mindustry.gen.Player
import mindustry.net.NetConnection
import net.ddns.mindustry.segment.ui.Child

class BaseMenu(
    title: String,
    message: String,
    override val id: Int,
    private var options: Array<Array<String>>,
    var option: Int,
    callback: (Player, Child) -> Unit,
    persist: Boolean = false
) : Child(title, message, id, callback, persist=persist) {
    override fun show() {
        Call.menu(this.id, this.title, this.message, this.options)
    }

    override fun show(connection: NetConnection) {
        Call.menu(connection, this.id, this.title, this.message, this.options)
    }

    /**
     * Rather than showing a normal menu, it instead shows a followup menu. A followup menu prevents any "flashing" from
     *      * a regular menu closing and another one opening immediately after.
     * @param base: An object of type `FollowupBase`, which stores the ID for the series of followup menus.
     */
    fun showFollowup(base: FollowupBase) {
        Call.followUpMenu(base.id, this.title, this.message, this.options)
    }

    /**
     * Rather than showing a normal menu, it instead shows a followup menu. A followup menu prevents any "flashing" from
     * a regular menu closing and another one opening immediately after.
     * @param connection: The `NetConnection` object from the `Player` object.
     * @param base: An object of type `FollowupBase`, which stores the ID for the series of followup menus.
     */
    fun showFollowup(connection: NetConnection, base: FollowupBase) {
        Call.followUpMenu(base.id, this.title, this.message, this.options)
    }
}