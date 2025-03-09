package net.ddns.mindustry.segment

import mindustry.net.Administration

var testingConfig: Administration.Config? = null

fun loadConfigs() {
    testingConfig = Administration.Config("testing-mode", "Whether the Segment framework is testing " +
            "functionality.", false)
}
