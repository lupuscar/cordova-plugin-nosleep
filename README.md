# cordova-plugin-nosleep
Un plugin para evitar que el dispositivo entre en suspensión.
## Instalación:
```bash
cordova plugin add git+https://github.com/lupuscar/cordova-plugin-nosleep.git
```
## Eliminación:
```bash
cordova plugin remove cordova-plugin-nosleep
```
## Utilización:
```js
document.addEventListener('deviceready', function() {
    // Activar WakeLock
    
    NoSleepPlugin.activate(function(success) {
        console.log("WakeLock activado: " + success);
    }, function(error) {
        console.error("Error al activar WakeLock: " + error);
    });

    // Desactivar WakeLock después de 10 segundos
    setTimeout(function() {
        NoSleepPlugin.deactivate(function(success) {
            console.log("WakeLock desactivado: " + success);
        }, function(error) {
            console.error("Error al desactivar WakeLock: " + error);
        });
    }, 10000);
});
```

