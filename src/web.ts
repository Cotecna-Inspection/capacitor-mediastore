import { WebPlugin } from '@capacitor/core';

import type {
    MediastorePlugin, SavePictureOptions, SaveMediaResult,
    SaveToDownloadsOptions, SaveVideoOptions
} from './definitions';

/**
 * Defines a Plugin for handling Media (Video, Photo, File) related actions.
 * @implements {MediastorePlugin}
 * @extends {WebPlugin} 
 * @public
 * @class
 */
export class MediastoreWeb extends WebPlugin implements MediastorePlugin {

    /**
     * Saves Pictures onto Devices' Media Store
     * @public
     * @async
     * @param options  Save Picture Options. Album, File Name and File Path
     * @returns {Promise<SaveMediaResult>} Promise object represents Save Media Result. Uri
     */
    async savePicture(options: SavePictureOptions): Promise<SaveMediaResult> {
        return new Promise((resolve, reject) => {
            void options;
            void resolve;
            reject('web is not supported');
        });
    }

    /**
     * Saves Files onto Devices' Downloads Folder
     * @public
     * @async
     * @param options Save Download Options. File Name and File Path
     * @returns {Promise<SaveMediaResult>} Promise object represents the Save Media Result. Uri
     */
    async saveToDownloads(options: SaveToDownloadsOptions): Promise<SaveMediaResult> {
        return new Promise((resolve, reject) => {
            void options;
            void resolve;
            reject('web is not supported');
        });
    }

    /**
     * Saves Videos onto Devices' Media Store
     * @public
     * @async
     * @param options Album, File Name and File Path
     * @returns {Promise<SaveMediaResult>} Promise object represents the Save Media Result. Uri
     */
    async saveVideo(options: SaveVideoOptions): Promise<SaveMediaResult> {
        return new Promise((resolve, reject) => {
            void options;
            void resolve;
            reject('web is not supported');
        });
    }
}
