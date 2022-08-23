package domine.datasource.aircraf

import domine.model.AirCraft

interface AirCraftDataSource {
    fun getAirCrafts():List<AirCraft>
}