val amerTzPrefix = "America/"
val amerTz = for(tz <- java.util.TimeZone.getAvailableIDs
    if tz.startsWith(amerTzPrefix))
  yield tz.stripPrefix(amerTzPrefix)
amerTz

