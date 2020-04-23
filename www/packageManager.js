function PackageManagerPlugin() {
};

PackageManagerPlugin.prototype.hasSystemFeature = function(feature, success, error) {
    cordova.exec(success, error, 'PackageManagerPlugin', 'hasSystemFeature', [feature]);
};

PackageManagerPlugin.prototype.isPackageInstalled = function(package, success, error) {
    cordova.exec(success, error, 'PackageManagerPlugin', 'isPackageInstalled', [package]);
};

module.exports = new PackageManagerPlugin();
