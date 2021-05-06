#import "SaveDevicePlugin.h"
#if __has_include(<save_device/save_device-Swift.h>)
#import <save_device/save_device-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "save_device-Swift.h"
#endif

@implementation SaveDevicePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftSaveDevicePlugin registerWithRegistrar:registrar];
}
@end
