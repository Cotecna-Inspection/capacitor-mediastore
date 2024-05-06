/**
 * Defines a Plugin for handling Media (Video, Photo, File) related actions
 * @public
 * @interface
 */
export interface MediastorePlugin {
    
     /**
    * Saves Pictures onto Devices' Media Store
    * @public
    * @async
    * @param options  Save Picture Options. Album, File Name and File Path
    * @returns {Promise<SaveMediaResult>} Promise object represents Save Media Result
    */
     savePicture(options: SavePictureOptions): Promise<SaveMediaResult>;

     /**
    * Saves Files onto Devices' Downloads Folder
    * @public
    * @async
    * @param options Save Download Options. File Name and File Path
    * @returns {Promise<SaveMediaResult>} Promise object represents the Save Media Result
    */
     saveToDownloads(options: SaveToDownloadsOptions): Promise<SaveMediaResult>;
 
     /**
     * Saves Videos onto Devices' Media Store
     * @public
     * @async
     * @param options Album, File Name and File Path
     * @returns {Promise<SaveMediaResult>} Promise object represents the Save Media Result
     */
     saveVideo(options: SaveVideoOptions): Promise<SaveMediaResult>;
}

/**
 * Defines a Media, Save Picture, Options. Album, File Name and File Path
 * @public
 * @interface
 */
export interface SavePictureOptions {
    album?: string;
    filename: string;
    path: string;
}

/**
 * Defines a Media, Save Download, Options. File Name and File Path
 * @public
 * @interface
 */
export interface SaveToDownloadsOptions {
    filename?: string;
    path: string;
}

/**
 * Defines a Media, Save Picture, Options. Album, File Name and File Path
 * @public
 * @interface
 */
export interface SaveVideoOptions {
    album?: string;
    filename: string;
    path: string;
}

/**
 * Defines a Media, Save Result. Uri
 * @public
 * @interface
 */
export interface SaveMediaResult
{
    uri:string;
}