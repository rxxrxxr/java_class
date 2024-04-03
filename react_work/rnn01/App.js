import { StatusBar } from 'expo-status-bar';
import { Button, Pressable, StyleSheet, Text, View } from 'react-native';

export default function App() {
  const [aa,setAA] = useState("aa");
  const doA = () => {
    fetch("http://localhost:3000/api/v1/test")
    .then(response => response.json)
    .then(data => console.log(data))
  }
  const doB = () => {
    setAA("bb");
  }

  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
      <StatusBar style="auto" />
      <View>
        <text>{aa}</text>
        <Button title="Press me" onPress={doB} />
      </View>
      <Pressable onPress={doA}>
        <Text>Press me</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
