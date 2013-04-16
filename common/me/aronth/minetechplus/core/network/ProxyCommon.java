package me.aronth.minetechplus.core.network;

import me.aronth.minetechplus.MineTechPlus;
import me.aronth.minetechplus.client.gui.GuiBookOfWondering;
import me.aronth.minetechplus.client.gui.GuiIdea;
import me.aronth.minetechplus.core.Reference;
import me.aronth.minetechplus.core.helpers.IdeaHandler;
import me.aronth.minetechplus.inventory.ContainerIdea;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyCommon implements IGuiHandler{
	
	public void registerHandlers(){
		GameRegistry.registerCraftingHandler(new IdeaHandler());
		NetworkRegistry.instance().registerGuiHandler(MineTechPlus.instance, this);
		
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_IDEA)
			return new ContainerIdea(player);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_IDEA)
			return new GuiIdea(player);
		if(ID == Reference.GUI_BOOKOFWONDERING)
			return new GuiBookOfWondering(player);
		return null;
	}
	
}
