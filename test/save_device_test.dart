import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:save_device/save_device.dart';

void main() {
  const MethodChannel channel = MethodChannel('save_device');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  // test('getPlatformVersion', () async {
  //   expect(await SaveDevice.platformVersion, '42');
  // });
}
