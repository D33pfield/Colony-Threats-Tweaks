# colony threats tweaks

lunalib wrapper around vanilla hostile-activity / colony-threat settings.

## requires

- [lunalib](https://github.com/Lukas22041/LunaLib) 
- [lazylib](https://github.com/LazyWizard/lazylib)

## install

drop the `Colony-Threats-Tweaks` folder into `Starsector/mods`. enable it in the launcher.

## use

open lunalib settings (main menu mod settings).

tabs:

- **general** — monthly HA cap, fleet caps, blowback
- **pathers** — cells, interest, tithe, base-kill reductions
- **pirates** — kanta, hidden bases, raid grace period
- **hegemony** — ai-core points and inspections
- **other** — league, tri-tach, diktat, church, remnant nexus
- **raids** — raid cooldown, bombard leftovers

defaults match vanilla 0.98a.

## pather cheat-sheet

to make pathers almost stop feeding the meter after you smash cells/bases:

- `patherProgressMultSleeperCells` = 0
- `patherProgressMultActiveCells` = 0.8 (or 0)
- `patherProgressMultNoCells` is already 0 vanilla

to stall all pather HA: set the three progress mults to 0.

to stall the whole crisis meter: `ha_maxMonthlyProgress` = 0 (and the easy variant).

raising `minInterestForPatherCells` makes cells rarer.

## notes

if a value looks sticky, save + reload.

this is a utility mod (`utility: true`). removing it from a save is supposed to be safe; values revert to whatever other mods / vanilla merged.

no jar. starsector compiles `data/scripts/...` on load.
