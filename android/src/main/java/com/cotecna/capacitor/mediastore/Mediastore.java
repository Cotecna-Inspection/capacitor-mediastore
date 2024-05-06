package com.cotecna.capacitor.mediastore;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Mediastore {

    public String savePicture(Context context, String album, String filename, String path) throws Exception {
        ContentResolver resolver = context.getContentResolver();

        // Get the collection for images
        Uri pictureCollection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);

        // Create ContentValues for the new picture details
        ContentValues newPictureDetails = new ContentValues();
        newPictureDetails.put(MediaStore.Images.Media.DISPLAY_NAME, filename);

        if (album != null) {
            newPictureDetails.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/" + album);
        }

        newPictureDetails.put(MediaStore.Images.Media.IS_PENDING, 1);

        // Insert the new picture into the collection
        Uri pictureContentUri = resolver.insert(pictureCollection, newPictureDetails);

        // Copy the file to the picture content URI
        this.copyFile(resolver, path, pictureContentUri);

        // Clear the ContentValues and update the picture status
        newPictureDetails.clear();
        newPictureDetails.put(MediaStore.Images.Media.IS_PENDING, 0);
        resolver.update(pictureContentUri, newPictureDetails, null, null);

        return pictureContentUri.toString();
    }

    public String saveToDownloads(Context context, String filename, String path) throws Exception {
        Path filePath = Paths.get(path);

        if (filename == null) {
            filename = filePath.getFileName().toString();
        }

        long size = Files.size(filePath);
        String mimeType = Files.probeContentType(filePath);

        ContentResolver resolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Downloads.DISPLAY_NAME, filename);
        contentValues.put(MediaStore.Downloads.MIME_TYPE, mimeType);
        contentValues.put(MediaStore.Downloads.SIZE, size);

        Uri targetUri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);

        copyFile(resolver, path, targetUri);

        return targetUri.toString();
    }

    public String saveVideo(Context context, String album, String filename, String path) throws Exception {
        ContentResolver resolver = context.getContentResolver();

        // Get the video collection URI
        Uri videoCollection = MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);

        // Create a ContentValues object to store video details
        ContentValues newVideoDetails = new ContentValues();
        newVideoDetails.put(MediaStore.Video.Media.DISPLAY_NAME, filename);

        if (album != null) {
            newVideoDetails.put(MediaStore.Video.Media.RELATIVE_PATH, "Movies/" + album);
        }

        newVideoDetails.put(MediaStore.Video.Media.IS_PENDING, 1);

        // Insert the new video details into the video collection
        Uri videoContentUri = resolver.insert(videoCollection, newVideoDetails);

        // Copy the video file to the specified location
        this.copyFile(resolver, path, videoContentUri);

        // Clear the ContentValues object for reuse
        newVideoDetails.clear();
        newVideoDetails.put(MediaStore.Video.Media.IS_PENDING, 0);

        // Update the video details to mark it as not pending
        resolver.update(videoContentUri, newVideoDetails, null, null);

        // Return the video content URI as a string
        return videoContentUri.toString();
    }

    private void copyFile(ContentResolver resolver, String inputPath, Uri outputUri) throws Exception {
        try {
            Path sourcePath = Paths.get(inputPath);
            Path targetPath = Paths.get(outputUri.getPath());

            // Read from source file
            byte[] data = Files.readAllBytes(sourcePath);

            // Write to target file
            Files.write(targetPath, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            resolver.delete(outputUri, null, null);
            throw new Exception("Unable to copy file - " + e.getMessage());
        }
    }
}
