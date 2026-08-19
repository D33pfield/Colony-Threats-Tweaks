package data.scripts.colonythreats;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import lunalib.lunaSettings.LunaSettings;
import lunalib.lunaSettings.LunaSettingsListener;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class ColonyThreatsPlugin extends BaseModPlugin implements LunaSettingsListener {

    public static final String MOD_ID = "colony_threats_tweaks";

    private static final Logger log = Global.getLogger(ColonyThreatsPlugin.class);

    private static final String[] FLOAT_KEYS = {
            "patherProgressMultNoCells",
            "patherProgressMultSleeperCells",
            "patherProgressMultActiveCells",
            "patherProgressUnit",
            "patherProgressMult",
            "luddicPathSmallFleetProb",
            "luddicPathSleeperCellsBase",
            "luddicPathSleeperCellsPerSize",
            "luddicPathActiveCellsBase",
            "luddicPathActiveCellsPerSize",
            "luddicPathPerPointOfInterest",
            "basePatherCellFraction",
            "luddicPathCellsIncidentProbabilityPerMonth",
            "blowbackFraction",
            "blowbackPerMonth",
            "pirateProtectionPaymentFraction",
            "pirateProtectionMercSpawnChance",
            "hegemonyProgressUnit",
            "hegemonyProgressMult",
            "hegemonyPerAICorePoint",
            "aiInspectionFrequencyMult",
            "perseanLeagueFeeFraction",
            "houseHannanFeeFraction",
            "triTachyonProgressPerUnitProdMult",
            "diktatProgressPerUnitProdMult",
            "diktatFuelFeeFraction",
            "diktatDefeatedExportBonus",
            "bombardFuelFraction"
    };

    private static final String[] INT_KEYS = {
            "ha_maxMonthlyProgress",
            "ha_maxMonthlyProgressEasy",
            "maxHostileActivityFleetsPerSystem",
            "HA_fleetPointsPerPoint",
            "luddicPathMaxFleets",
            "minInterestForPatherCells",
            "patherCellDisruptionDuration",
            "luddicPathTithePerPointOfInterestPerColonySize",
            "luddicPathTitheDurationDays",
            "HA_patherBaseFlat",
            "HA_patherBasePerActiveCell",
            "HA_patherBaseMax",
            "HA_megaTithe",
            "minLPBases",
            "maxLPBases",
            "HA_kantaProtection",
            "minPirateBases",
            "maxPirateBases",
            "noPirateRaidDays",
            "hegemonyPointsAdmin",
            "hegemonyPointsAlpha",
            "hegemonyPointsBeta",
            "hegemonyPointsGamma",
            "hegemonyMaxFleets",
            "perseanLeagueMaxFleets",
            "triTachyonMaxFleets",
            "diktatMaxFleets",
            "luddicChurchMaxFleets",
            "remnantNexusPointsDamaged",
            "remnantNexusPointsNormal",
            "raidCooldownDays",
            "raidDefenderIncreasePerRaid",
            "raidDefenderIncreaseMax",
            "bombardDisruptDuration"
    };

    @Override
    public void onApplicationLoad() {
        LunaSettings.addSettingsListener(this);
        applySettings();
    }

    @Override
    public void onGameLoad(boolean newGame) {
        applySettings();
    }

    @Override
    public void settingsChanged(String modId) {
        if (MOD_ID.equals(modId)) {
            applySettings();
        }
    }

    public static void applySettings() {
        try {
            JSONObject json = Global.getSettings().getSettingsJSON();

            for (String key : FLOAT_KEYS) {
                Double value = LunaSettings.getDouble(MOD_ID, key);
                if (value == null) continue;
                json.put(key, value.doubleValue());
                Global.getSettings().setFloat(key, value.floatValue());
            }

            for (String key : INT_KEYS) {
                Integer value = LunaSettings.getInt(MOD_ID, key);
                if (value == null) continue;
                json.put(key, value.intValue());
                Global.getSettings().setFloat(key, value.floatValue());
            }

            Global.getSettings().resetCached();
            log.info("colony threats tweaks: applied luna settings to vanilla settings.json keys");
        } catch (Exception e) {
            log.error("colony threats tweaks: failed to apply settings", e);
        }
    }
}
