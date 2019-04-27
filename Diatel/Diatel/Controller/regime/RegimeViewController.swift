//
//  RegimeViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class RegimeViewController: UIViewController,UITableViewDelegate,UITableViewDataSource {

    

    @IBOutlet weak var leftdays: UIView!
    @IBOutlet weak var regimeprogram: UIView!
    @IBOutlet weak var tableview: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad();
        leftdays.layer.cornerRadius = 10
        regimeprogram.layer.cornerRadius = 10

        // Do any additional setup after loading the view.
        tableview.dataSource = self
        tableview.delegate = self
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        return cell
    }

}
