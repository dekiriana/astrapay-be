# 🚀 Panduan Menjalankan Proyek Spring Boot

Proyek ini menggunakan **Maven** untuk *build* dan *run* aplikasi. Pastikan Anda memiliki Java Development Kit (**JDK**) dan **Maven** yang terinstal di sistem Anda.

## 1\. 📂 Navigasi ke Direktori Proyek

Buka terminal atau Command Prompt, dan navigasi ke direktori *root* proyek Anda (tempat file `pom.xml` berada):

```bash
cd D:\project\challange\astrapay-spring-boot-external
```

## 2\. 🧹 Clean Build (Kompilasi dan Persiapan)

Langkah ini sangat penting untuk membersihkan *build* lama dan memastikan semua *resource* (seperti `messages.properties`) dan kode Java (*entity*, *dto*, *service*) dikompilasi dengan benar.

Jalankan perintah ini:

```bash
mvn clean install
```

| Output Diharapkan | Keterangan |
| :--- | :--- |
| `[INFO] BUILD SUCCESS` | Proses kompilasi dan pembuatan JAR berhasil. |
| `[INFO] COMPILATION ERROR` | Masih ada masalah kode (misalnya, *setter* yang hilang atau *import* yang salah). Harus diperbaiki sebelum lanjut. |

## 3\. 🏃 Menjalankan Aplikasi

Setelah *clean build* berhasil, jalankan *project* menggunakan *plugin* Spring Boot Maven:

```bash
mvn spring-boot:run
```

  * **Server:** Aplikasi akan mulai berjalan di *embedded* Tomcat, biasanya pada *port* **8080**.
  * **Verifikasi:** Tunggu hingga Anda melihat log yang mirip dengan: `Started NotesApplication in X.XX seconds (JVM running for Y.YYY)`.

## 4\. 🧪 Verifikasi dan Pengujian Endpoint

Setelah aplikasi berjalan, Anda dapat menguji *endpoint* API Anda melalui *browser* atau Postman.

### (Dokumentasi)

Akses antarmuka dokumentasi interaktif Anda untuk melihat semua *endpoint* (CRUD, Update State):

```
{
	"info": {
		"_postman_id": "038c6d91-23d5-45a8-94b2-4d2c88f98c8c",
		"name": "Astrapay Simple Notes API (V2 - With Category)",
		"description": "Collection untuk menguji CRUD In-Memory Simple Notes Application dengan field Category baru.",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Notes CRUD",
			"item": [
				{
					"name": "1. Create New Note (POST)",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									"pm.test(\"Status code is 201 Created\", function () {",
									"    pm.response.to.have.status(201);",
									"});",
									"var jsonData = pm.response.json();",
									"pm.environment.set(\"noteId\", jsonData.id);",
									"pm.test(\"Note ID stored: \" + jsonData.id, function () {",
									"    pm.expect(jsonData.id).to.be.a('number');",
									"});"
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"title\": \"Rapat Harian Tim PD\",\n    \"content\": \"Memprioritaskan refactoring Lombok dan perbaikan MessageSource.\",\n    \"category\": \"WORK\" \n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{baseUrl}}/notes",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes"
							]
						}
					}
				},
				{
					"name": "2. Get All Notes (GET)",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/notes",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes"
							]
						}
					}
				},
				{
					"name": "3. Update Note Content (PUT)",
					"request": {
						"method": "PUT",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"title\": \"Judul Setelah Update\",\n    \"content\": \"Konten baru: Jangan lupa beli kopi.\",\n    \"category\": \"PERSONAL\" \n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{baseUrl}}/notes/{{noteId}}",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes",
								"{{noteId}}"
							]
						}
					}
				},
				{
					"name": "7. Delete Note",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/notes/{{noteId}}",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes",
								"{{noteId}}"
							]
						}
					}
				}
			]
		},
		{
			"name": "State Update (PATCH)",
			"item": [
				{
					"name": "4. Publish Note (PATCH)",
					"request": {
						"method": "PATCH",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/notes/{{noteId}}/publish",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes",
								"{{noteId}}",
								"publish"
							]
						}
					}
				},
				{
					"name": "4. Archive Note (PATCH)",
					"request": {
						"method": "PATCH",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/notes/{{noteId}}/archive",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes",
								"{{noteId}}",
								"archive"
							]
						}
					}
				}
			]
		},
		{
			"name": "Error Handling",
			"item": [
				{
					"name": "5. Validation Fail (Missing Category) - 400",
					"request": {
						"method": "POST",
						"header": [
							{
								"key": "Content-Type",
								"value": "application/json"
							}
						],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"title\": \"Test Invalid\",\n    \"content\": \"Konten valid\",\n    \"category\": null \n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{baseUrl}}/notes",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes"
							]
						}
					}
				},
				{
					"name": "6. Not Found Fail (DELETE 404)",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "{{baseUrl}}/notes/99999",
							"host": [
								"{{baseUrl}}"
							],
							"path": [
								"notes",
								"99999"
							]
						}
					}
				}
			]
		}
	],
	"protocolProfileBehavior": {}
}
```

### B. Cek Endpoint API (Postman)

Gunakan *collection* Postman yang sudah dibuat untuk menguji fungsionalitas CRUD secara berurutan.

| Tujuan Uji | Method | URL | Status Diharapkan |
| :--- | :--- | :--- | :--- |
| **Create Note** | `POST` | `http://localhost:8080/notes` | `201 Created` |
| **Get All** | `GET` | `http://localhost:8080/notes` | `200 OK` |
| **Delete Not Found** | `DELETE` | `http://localhost:8080/notes/99999` | `404 Not Found` |

-----

**Proyek Anda sekarang sudah berjalan dan siap untuk pengembangan Front-End Angular.**
