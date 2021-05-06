import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:save_device/save_device.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  bool _isRealDevice = false, _isRooted = false;

  @override
  void initState() {
    super.initState();
    initIsRootedState();
    initIsRealDeviceState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initIsRootedState() async {
    bool isRooted;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      isRooted = await SaveDevice.isRooted;
    } on PlatformException {
      isRooted = false;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      this._isRooted = isRooted;
    });
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initIsRealDeviceState() async {
    bool isRealDevice;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      isRealDevice = await SaveDevice.isRealDevice;
    } on PlatformException {
      isRealDevice = false;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      this._isRealDevice = isRealDevice;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Save Device  example app'),
        ),
        body: Center(
          child: Column(
            children: [
              Text('is Real Device: $_isRealDevice\n'),
              Text('is Rooted: $_isRooted\n'),
            ],
          ),
        ),
      ),
    );
  }
}
