package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.Chisel;

public class BlockEldritch extends BlockCarvable {

	public BlockEldritch(int i) {
		super(i);
	}

	@Override
	public int getRenderType() {
		return Chisel.renderEldritchId;
	}

}
