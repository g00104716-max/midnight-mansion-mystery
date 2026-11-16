# Midnight Mansion Mystery

CMP358L course project: a text-based detective game written in Java.

A diamond necklace has disappeared during a blackout at Blackwood Mansion. The player visits rooms, collects evidence, interviews suspects and witnesses, and accuses the thief.

## Features

- Menu-driven console gameplay
- Four locations: Hallway, Dining Room, Study, Display Room
- Characters to interview: suspect, witness and informant
- Evidence collection and sorting by ID or relevance
- Investigation progress tracking
- Case details loaded from a text file (`case_info.txt`)
- Investigation report saved to `investigation_report.txt`

## Requirements

- Java 21 (JDK)

## How to run

### Eclipse

1. File → Import → General → Existing Projects into Workspace
2. Select this folder
3. Run `src/finalgame/Game.java`

### Command line

From the project folder:

```bash
javac -d bin src/finalgame/*.java
java -cp bin finalgame.Game
```
