import java.awt.datatransfer._

val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]

flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray.toBuffer