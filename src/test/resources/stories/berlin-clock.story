Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Just After Morning
When the time is 06:33:15
Then the clock should look like
O
ROOO
ROOO
YYRYYROOOOO
YYYO

Scenario: Just Before Noon
When the time is 11:38:10
Then the clock should look like
Y
RROO
ROOO
YYRYYRYOOOO
YYYO

Scenario: Evening
When the time is 18:00:00
Then the clock should look like
Y
RRRO
RRRO
OOOOOOOOOOO
OOOO

Scenario: Night
When the time is 21:00:00
Then the clock should look like
Y
RRRR
ROOO
OOOOOOOOOOO
OOOO