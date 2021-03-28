import React, { Component } from 'react';
import { MapContainer, GeoJSON, TileLayer } from 'react-leaflet'
import data from './../data/countries.json'
import 'leaflet/dist/leaflet.css'
import './Map.css'

/*
  REGION NUMBERS GUIDE:
  0: Southwest Asia & Northern Africa
  1: Sub-Saharan Africa & Australia
  2: Monsoon Asia
  3: Europe & Russia
  4: Western Hemisphere
*/


/**
 * Highlights a layer that was hovered over in the map
 *
 * @param {*} e the object that was hovered over
 *
 * @author Ethan Maher
 */
function highlight(e) {
  const layer = e.target;
  console.log(layer)
  layer.setStyle({
    color: '#ffff00',
    fillColor: '#ffff00'
  })
  layer.bringToFront();
}

/**
 * Unhighlights a layer that is no longer hovered over based on the region that layer is in (determined in JSON properties)
 *
 * @param {*} e the object that was stopped being hovered over
 *
 * @author Ethan Maher
 */
function resetHighlight(e) {
  const layer = e.target;
  layer.setStyle({
    weight: 1,
    color: 'black',
    fillColor: getColors(layer.feature)
  })
}

/**
 * Returns the correct color of a layer from the REGION property in the JSON
 *
 * @param {*} layer the layer to get the original color of
 *
 * @returns the color that the layer needs to be
 *
 * @author Ethan Maher
 */
function getColors(feature) {
  const regionNumber = feature.properties.REGION;
  switch (regionNumber) {
    case 0: return 'yellow';
    case 1: return 'red';
    case 2: return 'green';
    case 3: return 'aqua';
    case 4: return 'blue';
    default: return 'black';
  }
}

/**
 * Class for Map component
 *
 * @author Ethan Maher
 */
class Map extends Component {
  componentDidMount() {
    console.log(data)
  }

  onEachCountry = (country, layer) => {
    layer.bindPopup(function () {
      const url = "/pages/" + country.properties.ADMIN + "/General%20Info.html"
      return country.properties.ADMIN + "<br /><a href=" + url + ">View More</a>";
    })

    layer.on({
      mouseover: highlight,
      mouseout: resetHighlight
    })
  }

  render() {
    return (
      <div>
      <h1> My Map</h1>
        <MapContainer style={{ height: "90vh" }} minZoom={2} maxZoom={7} zoom={2} center={[12.345, 12.345]}>
          <TileLayer
            attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          />

          <GeoJSON
            style={
              function (feature) {
                return {
                  fillColor: getColors(feature),
                  weight: 1,
                  fillOpacity: .4,
                  color: 'black'
                }
              }
            }
            data={data.features}
            onEachFeature={this.onEachCountry}
          />
        </MapContainer>
        </div>
    )
  }
}

export default Map