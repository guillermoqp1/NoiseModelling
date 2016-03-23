/*
 * NoiseMap is a scientific computation plugin for OrbisGIS developed in order to
 * evaluate the noise impact in urban areas. This model is
 * based on the French standard method NMPB2008. It includes traffic-to-noise
 * sources evaluation and sound propagation processing.
 *
 * This plugin is currently developed by the Environmental Acoustics Laboratory (LAE) of Ifsttar
 * (http://wwww.lae.ifsttar.fr/) in collaboration with the Lab-STICC CNRS laboratory.
 * It was initially developed as part of the Eval-PDU project, funded by the
 * French Agence Nationale de la Recherche (ANR) under contract ANR-08-VILL-0005-01.
 *
 * Noisemap is distributed under GPL 3 license. Its reference contact is Judicaël
 * Picaut <judicael.picaut@ifsttar.fr>. It is maintained by Nicolas Fortin
 * <nicolas.fortin@ifsttar.fr>
 *
 * Copyright (C) 2011-2016 IFSTTAR-CNRS
 *
 * Noisemap is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Noisemap is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Noisemap. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information concerning NoiseM@p, please consult: <http://noisemap.orbisgis.org/>
 *
 * For more information concerning OrbisGis, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 *
 * info_at_ orbisgis.org
 */
package org.orbisgis.noisemap.core;

import java.util.HashMap;

/**
 * 
 * @author Nicolas Fortin
 */
public class VehicleSpectrumRepartition {

	private final static HashMap<Integer, Integer> freqToIndex = new HashMap<Integer, Integer>();
    static {
        freqToIndex.put(100, 0);
        freqToIndex.put(125, 1);
        freqToIndex.put(160, 2);
        freqToIndex.put(200, 3);
        freqToIndex.put(250, 4);
        freqToIndex.put(315, 5);
        freqToIndex.put(400, 6);
        freqToIndex.put(500, 7);
        freqToIndex.put(630, 8);
        freqToIndex.put(800, 9);
        freqToIndex.put(1000, 10);
        freqToIndex.put(1250, 11);
        freqToIndex.put(1600, 12);
        freqToIndex.put(2000, 13);
        freqToIndex.put(2500, 14);
        freqToIndex.put(3150, 15);
        freqToIndex.put(4000, 16);
        freqToIndex.put(5000, 17);

    }
	private final static double[] non_pervious_att = { -27, -26, -24, -21, -19, -16, -14,
			-11, -11, -8, -7, -8, -10, -13, -16, -18, -21, -23 };

    /**
     * Utility class
     */
	private VehicleSpectrumRepartition() {
	}

    /**
     * @param freq Frequency index [0-17]
     * @return Road noise
     * @throws IllegalArgumentException If the frequency index is out of bound.
     */
	public static double getAttenuatedValue(int freq) throws IllegalArgumentException {
		if (freqToIndex.containsKey(freq)) {
			return non_pervious_att[freqToIndex.get(freq)];
		} else {
			throw new IllegalArgumentException("The frequency " + freq
					+ " Hz is unknown !");
		}
	}
}
