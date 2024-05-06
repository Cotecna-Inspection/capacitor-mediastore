# @cotecna/capacitor-mediastore

Manage operations over hand held devices' (Web | Android | IOS) media files

## Install

```bash
npm install @cotecna/capacitor-mediastore
npx cap sync
```

## API

<docgen-index>

* [`savePicture(...)`](#savepicture)
* [`saveToDownloads(...)`](#savetodownloads)
* [`saveVideo(...)`](#savevideo)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

Defines a Plugin for handling Media (Video, Photo, File) related actions

### savePicture(...)

```typescript
savePicture(options: SavePictureOptions) => Promise<SaveMediaResult>
```

Saves Pictures onto Devices' Media Store

| Param         | Type                                                              | Description                                          |
| ------------- | ----------------------------------------------------------------- | ---------------------------------------------------- |
| **`options`** | <code><a href="#savepictureoptions">SavePictureOptions</a></code> | Save Picture Options. Album, File Name and File Path |

**Returns:** <code>Promise&lt;<a href="#savemediaresult">SaveMediaResult</a>&gt;</code>

--------------------


### saveToDownloads(...)

```typescript
saveToDownloads(options: SaveToDownloadsOptions) => Promise<SaveMediaResult>
```

Saves Files onto Devices' Downloads Folder

| Param         | Type                                                                      | Description                                    |
| ------------- | ------------------------------------------------------------------------- | ---------------------------------------------- |
| **`options`** | <code><a href="#savetodownloadsoptions">SaveToDownloadsOptions</a></code> | Save Download Options. File Name and File Path |

**Returns:** <code>Promise&lt;<a href="#savemediaresult">SaveMediaResult</a>&gt;</code>

--------------------


### saveVideo(...)

```typescript
saveVideo(options: SaveVideoOptions) => Promise<SaveMediaResult>
```

Saves Videos onto Devices' Media Store

| Param         | Type                                                          | Description                    |
| ------------- | ------------------------------------------------------------- | ------------------------------ |
| **`options`** | <code><a href="#savevideooptions">SaveVideoOptions</a></code> | Album, File Name and File Path |

**Returns:** <code>Promise&lt;<a href="#savemediaresult">SaveMediaResult</a>&gt;</code>

--------------------


### Interfaces


#### SaveMediaResult

Defines a Media, Save Result. Uri

| Prop      | Type                |
| --------- | ------------------- |
| **`uri`** | <code>string</code> |


#### SavePictureOptions

Defines a Media, Save Picture, Options. Album, File Name and File Path

| Prop           | Type                |
| -------------- | ------------------- |
| **`album`**    | <code>string</code> |
| **`filename`** | <code>string</code> |
| **`path`**     | <code>string</code> |


#### SaveToDownloadsOptions

Defines a Media, Save Download, Options. File Name and File Path

| Prop           | Type                |
| -------------- | ------------------- |
| **`filename`** | <code>string</code> |
| **`path`**     | <code>string</code> |


#### SaveVideoOptions

Defines a Media, Save Picture, Options. Album, File Name and File Path

| Prop           | Type                |
| -------------- | ------------------- |
| **`album`**    | <code>string</code> |
| **`filename`** | <code>string</code> |
| **`path`**     | <code>string</code> |

</docgen-api>
