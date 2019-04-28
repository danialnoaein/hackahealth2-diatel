//
//  ThirdViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class ThirdViewController: UIViewController {

    @IBOutlet weak var familyBackground: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        
        // Do any additional setup after loading the view.
        familyBackground.layer.borderColor = UIColor.white.cgColor
        familyBackground.layer.borderWidth = 1
        familyBackground.layer.cornerRadius = 10
    }




}
