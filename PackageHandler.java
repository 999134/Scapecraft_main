package net.minecraft.src;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public class PackageHandler implements IPacketHandler {
	public static final byte COMBAT = 0, AGILITY = 1;

	// Don't need to do anything here.
	public PackageHandler() {
	}

	private void handleSyncPropertiesPacket(Packet250CustomPayload packet, EntityPlayer player,
			DataInputStream inputStream) {

	}

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		try {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

			try {
				// read in the first byte; this is your packet id that you wrote at the very
				// beginning, e.g. COMBAT
				int combatXp;
				int agilityXp;
				int miningXp;
				int energy;
				int theifXp;
				int theifcd;

				// first get the data:
				try {
					combatXp = inputStream.readInt();
					agilityXp = inputStream.readInt();
					energy = inputStream.readInt();
					miningXp = inputStream.readInt();
					theifXp = inputStream.readInt();
					theifcd = inputStream.readInt();
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
				// second get your extended properties and set the values:
				ExtendedPlayer info = ExtendedPlayer.get((EntityPlayer) player);
				info.setcombatxp(combatXp);
				info.setagilityxp(agilityXp);
				info.setenergy(energy);
				info.setminingxp(miningXp);
				info.settheifxp(theifXp);
				info.settheifcd(theifcd);

				// now you can parse through your various packets, performing different actions
				// for each
			} finally {
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
