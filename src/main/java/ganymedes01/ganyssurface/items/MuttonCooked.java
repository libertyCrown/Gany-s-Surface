package ganymedes01.ganyssurface.items;

import ganymedes01.ganyssurface.GanysSurface;
import ganymedes01.ganyssurface.core.utils.Utils;
import ganymedes01.ganyssurface.lib.Strings;
import net.minecraft.item.ItemFood;

/**
 * Gany's Surface
 *
 * @author ganymedes01
 *
 */

public class MuttonCooked extends ItemFood {

	public MuttonCooked() {
		super(6, 0.8F, true);
		if (GanysSurface.enableMutton)
			setCreativeTab(GanysSurface.surfaceTab);
		else
			setCreativeTab(null);
		setTextureName(Utils.getItemTexture(Strings.COOKED_MUTTON));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.COOKED_MUTTON));
	}
}