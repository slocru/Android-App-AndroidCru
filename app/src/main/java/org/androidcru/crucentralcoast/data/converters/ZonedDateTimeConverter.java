package org.androidcru.crucentralcoast.data.converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.aaronhe.threetengson.ThreeTenGsonAdapter;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;

import java.lang.reflect.Type;

public class ZonedDateTimeConverter implements JsonDeserializer<ZonedDateTime>, JsonSerializer<ZonedDateTime>
{
    private static Gson gson;

    static
    {
        GsonBuilder builder = new GsonBuilder();
        builder = ThreeTenGsonAdapter.registerZonedDateTime(builder);
        gson = builder.create();
    }

    @Override
    public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {

        //TODO if the server can ever handle timezones properly, change to withZoneSameInstant
        return gson.toJsonTree(src.withZoneSameLocal(ZoneOffset.UTC));
    }

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        //TODO if the server can ever handle timezones properly, change to withZoneSameInstant
        return gson.fromJson(json, ZonedDateTime.class).withZoneSameLocal(ZoneOffset.UTC);
    }
}