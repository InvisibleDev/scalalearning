val gizmos = Map(("house", 295000), ("laptop", 1000), ("mob", 149))
val gizmoDiscounted = for((gizmo, price) <- gizmos) yield (gizmo, price * 0.9)

gizmos
gizmoDiscounted