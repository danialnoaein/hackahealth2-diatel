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
    let titles = ["۳ کف دست نان لواش - ۳۰ گرم پنیر - ۲ خیار", "۱۰ قاشق غذا خوری برنج - دو قوطی  کبریت از هرنوع گوشتی - ۳ قاشق غذاخوری خورشت","سه کف دست نان و کتلت - گوجه و خیارشور وماست"]
   let times = ["صبحانه","ناهار","شام"]
    override func viewDidLoad() {
        super.viewDidLoad();
        leftdays.layer.cornerRadius = 10
        regimeprogram.layer.cornerRadius = 10
        

        // Do any additional setup after loading the view.
        tableview.dataSource = self
        tableview.delegate = self
        let nibfile = UINib(nibName: "RegimeCellTableViewCell", bundle: nil);
        tableview.register(nibfile, forCellReuseIdentifier: "regimecell")
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "regimecell", for: indexPath) as! RegimeCellTableViewCell;
        cell.dayName.text = "شنبه"
        cell.meals.text = titles[indexPath.row]
        cell.titleText.text = times[indexPath.row]
        return cell
    }
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 140
    }

}
