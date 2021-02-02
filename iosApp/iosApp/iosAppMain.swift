//
//  iosAppMain.swift
//  iosApp
//
//  Created by Riccardo Testa on 02/02/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import main

@main
struct iosAppMain: App {
    @ObservedObject var appViewModel = AppViewModel()
        var body: some Scene {
            WindowGroup {
                ContentView(state: appViewModel.appState, sharedModel: appViewModel.sharedModel)
            }
        }
}

class AppViewModel: ObservableObject {
    let sharedModel : KMPViewModel = KMPViewModel()
    @Published var appState : AppState = AppState(personNameLabelText: "", people: [Person]())
    init() {
        sharedModel.onChange { newState in
            self.appState = newState
        }
    }
}
