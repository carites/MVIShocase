import SwiftUI
import main

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    var state: AppState
    var sharedModel: KMPViewModel
    @State private var username: String = ""
    var body: some View {
        NavigationView {
            VStack {
                List(state.people) { person in
                    PersonRow(person: person)
                }
                
                Text(state.personNameLabelText)
                TextField(
                        "User name (email address)",
                         text: $username
                ).onChange(of: username, perform: { value in
                    sharedModel.personNameChanged(name: value)
                }).padding(EdgeInsets(top: 8, leading: 32, bottom: 8, trailing: 32))
                Button("Create Name", action: {
                    sharedModel.createButtonPressed(name: username)
                    self.username = ""
                })
            }.textFieldStyle(RoundedBorderTextFieldStyle())
            
            
        }.onAppear() {
            sharedModel.doInitHomeScreen()
        }
    }
    
    
}

struct PersonRow: View {
    var person: Person

    var body: some View {
        Text("Welcome \(person.name)")
    }
}

extension Person: Identifiable {}
