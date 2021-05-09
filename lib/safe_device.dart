import 'dart:async';

import 'package:flutter/services.dart';

class SafeDevice {
  static const MethodChannel _channel = const MethodChannel('save_device');

  // Checks whether device is real or emulator
  static Future<bool> get isRealDevice async {
    final bool isRealDevice = await _channel.invokeMethod('isRealDevice');
    return isRealDevice;
  }

  //Checks whether device Rooted on iOS/Android?
  static Future<bool> get isRooted async {
    final bool isRooted = await _channel.invokeMethod('isRooted');
    return isRooted;
  }
}
