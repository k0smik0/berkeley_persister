/*******************************************************************************
 * Copyleft (c) 2015, "Massimiliano Leone - <maximilianus@gmail.com> - https://plus.google.com/+MassimilianoLeone"
 * This file (UrlPersisterProxy.java) is part of BerkeleyPersister.
 * 
 *     UrlPersisterProxy.java is free software: you can redistribute it and/or modify
 *     it under the terms of the Lesser GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 *     UrlPersisterProxy.java is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See   the Lesser GNU General Public License for more details.
 * 
 *     You should have received a copy of the Lesser GNU General Public License along with .  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package net.iubris.jbbp.core.entitymodel.proxies;

import java.net.MalformedURLException;
import java.net.URL;

import com.sleepycat.persist.model.Persistent;
import com.sleepycat.persist.model.PersistentProxy;

@Persistent(proxyFor=URL.class)
public class UrlPersisterProxy implements PersistentProxy<URL> {

	private String urlString;

	@Override
	public URL convertProxy() {
		try {
			return new URL(urlString);
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public void initializeProxy(URL url) {
		urlString = url.toString();
	}
}
