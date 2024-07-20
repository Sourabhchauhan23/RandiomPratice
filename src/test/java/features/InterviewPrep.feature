Feature:
  Verify Avatars on Page of the System

  Scenario: Verify Avatar's basic details on Page
    Given The user is on "Page".
    Then "Page" should have 6 AvatarId with AvatarName, AvatarEmail details.

@Run
  Scenario: Verify Avatar's basic details on Page
    Given The user is on "Page".
    Then The user is at "Page".