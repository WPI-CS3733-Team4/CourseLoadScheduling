package org.dselent.scheduling.server.controller.impl;

import org.dselent.scheduling.server.controller.LocationController;
import org.dselent.scheduling.server.dto.*;
import org.dselent.scheduling.server.miscellaneous.JsonResponseCreator;
import org.dselent.scheduling.server.model.Location;
import org.dselent.scheduling.server.requests.*;
import org.dselent.scheduling.server.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LocationControllerImpl implements LocationController{

    @Autowired
    private LocationService locationService;

    public ResponseEntity<String> locationAdd(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Location controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        String buildingName = request.get(LocationAdd.getBodyName(LocationAdd.BodyKey.BUILDING));
        Integer room = Integer.parseInt(request.get(LocationAdd.getBodyName(LocationAdd.BodyKey.ROOM)));
        Integer roomSize = Integer.parseInt(request.get(LocationAdd.getBodyName(LocationAdd.BodyKey.ROOM_SIZE)));

        LocationAddDto.Builder builder = LocationAddDto.builder();
        LocationAddDto locationAddDto = builder.withBuilding(buildingName)
                .withRoom(room)
                .withRoomSize(roomSize)
                .build();

        locationService.addLocation(locationAddDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> locationModify(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Location controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer locationId = Integer.parseInt(request.get(LocationModify.getBodyName(LocationModify.BodyKey.LOCATIONS_ID)));
        String buildingName = request.get(LocationAdd.getBodyName(LocationAdd.BodyKey.BUILDING));
        Integer room = Integer.parseInt(request.get(LocationAdd.getBodyName(LocationAdd.BodyKey.ROOM)));
        Integer roomSize = Integer.parseInt(request.get(LocationAdd.getBodyName(LocationAdd.BodyKey.ROOM_SIZE)));


        LocationModifyDto.Builder builder = LocationModifyDto.builder();
        LocationModifyDto locationModifyDto = builder.withLocationId(locationId)
                .withBuilding(buildingName)
                .withRoom(room)
                .withRoomSize(roomSize)
                .build();

        locationService.modifyLocation(locationModifyDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> locationRemove(@RequestBody Map<String, String> request) throws Exception
    {
        // Print is for testing purposes
        System.out.println("Location controller reached");

        // add any objects that need to be returned to the success list
        String response = "";
        List<Object> success = new ArrayList<Object>();

        Integer locationId = Integer.parseInt(request.get(LocationModify.getBodyName(LocationModify.BodyKey.LOCATIONS_ID)));

        LocationRemoveDto.Builder builder = LocationRemoveDto.builder();
        LocationRemoveDto locationRemoveDto = builder.withLocationId(locationId)
                .build();

        locationService.removeLocation(locationRemoveDto);
        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> getLocations(@RequestBody Map<String, String> request) throws Exception
    {
        System.out.println("Locations controller reached");


        //get all the users (how do we do the responseSet????)
        List<Location> listOfLocations = locationService.grabLocations();

        List<String> locationsEntryList = new ArrayList<String>();

        for (Location location : listOfLocations){
            locationsEntryList.add(location.toString());
        }

        String response = "";

        List<Object> success = new ArrayList<Object>();

        //Add the list of the users to the response
        success.add(listOfLocations);


        response = JsonResponseCreator.getJSONResponse(JsonResponseCreator.ResponseKey.SUCCESS, success);
        return new ResponseEntity<String>(response, HttpStatus.OK); // We will have to return some info about the user, like access permissions
    }

}
