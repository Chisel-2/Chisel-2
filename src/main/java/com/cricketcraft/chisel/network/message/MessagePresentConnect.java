package com.cricketcraft.chisel.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.cricketcraft.chisel.block.tileentity.TileEntityPresent;
import com.cricketcraft.chisel.network.message.base.MessageCoords;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;


public class MessagePresentConnect extends MessageCoords {
	
	private ForgeDirection dir;
	private boolean connect;
	
	public MessagePresentConnect() {
		super();
	}
	
	public MessagePresentConnect(TileEntityPresent present, ForgeDirection dir, boolean connecting) {
		super(present);
		this.dir = dir;
		this.connect = connecting;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		buf.writeInt(dir.ordinal());
		buf.writeBoolean(connect);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		dir = ForgeDirection.values()[buf.readInt()];
		connect = buf.readBoolean();
	}
	
	public static class Handler implements IMessageHandler<MessagePresentConnect, IMessage> {
		
		@Override
		public IMessage onMessage(MessagePresentConnect message, MessageContext ctx) {
			TileEntity te = message.getTileEntity(ctx);
			if (te instanceof TileEntityPresent) {
				if (message.connect) {
					((TileEntityPresent) te).connectTo(message.dir);
				} else {
					((TileEntityPresent) te).disconnect();
				}
			}
			return null;
		}
	}

}
