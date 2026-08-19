# colony threats tweaks

lunalib wrapper around vanilla hostile-activity / colony-threat settings. no more editing `starsector-core/data/config/settings.json`.

## requires

- lunalib (hard dependency)
- lazylib (lunalib already needs it)

## install

drop the `ColonyThreatsTweaks` folder into `Starsector/mods`. enable it in the launcher.

## use

open lunalib settings (campaign hotkey, usually f2/f3, or from new-game / main menu mod settings).

tabs:

- **general** — monthly HA cap, fleet caps, blowback
- **pathers** — the knobs you already found
- **pirates** — kanta, hidden bases, raid grace period
- **hegemony** — ai-core points and inspections
- **other** — league / tri-tach / diktat / church / remnant nexus
- **raids** — raid cooldown / bombard leftovers

defaults match vanilla 0.98a.

## what actually changes

the plugin writes into `SettingsAPI` (`setFloat` + `getSettingsJSON` + `resetCached`) on:

- application load
- game load
- luna "save settings"

monthly HA *gain* and a lot of spawn/interest checks read these keys live. already-accumulated HA on a save is not reset. if a value looks sticky, save + reload.

arrays are not exposed (e.g. `pirateBaseProximityPoints`, `HA_pirateBase`, timeout ranges). those need a merge-json or a more cursed json rewrite.

## pather cheat-sheet

to make pathers almost stop feeding the meter after you smash cells/bases:

- `patherProgressMultSleeperCells` = 0
- `patherProgressMultActiveCells` = 0.8 (or 0)
- `patherProgressMultNoCells` is already 0 vanilla

to stall all pather HA: set the three progress mults to 0.

to stall the whole crisis meter: `ha_maxMonthlyProgress` = 0 (and the easy variant).

raising `minInterestForPatherCells` makes cells rarer.

## notes

this is a utility mod (`utility: true`). removing it from a save is supposed to be safe; values revert to whatever other mods / vanilla merged.

no jar. starsector compiles `data/scripts/...` on load.
