//
//  TrainigViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class TrainigViewController: UIViewController,UICollectionViewDelegate,UICollectionViewDataSource,UICollectionViewDelegateFlowLayout {

    //MARK: Outlets and variables
    /**********************************************************/

    @IBOutlet weak var collectionview: UICollectionView!
    let titles = ["درمان و پیشگیری","تغذیه و رژیم","علائم بالینی","دارو خانه" ,"بیماری های مرتبط","مصاحبه پزشکان"];

    override func viewDidLoad() {
        super.viewDidLoad();
        collectionview.delegate = self
        collectionview.dataSource = self
        // Do any additional setup after loading the view.
        collectionview.register(UINib.init(nibName: "TraningCell", bundle: nil), forCellWithReuseIdentifier: "sectioncell")
    }
    
    
    
    //MARK: collectionview methods
    /**********************************************************/
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return titles.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "sectioncell", for: indexPath) as! TraningCell
        
        cell.layer.cornerRadius = 10
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        cell.setGradientBackground(colorTop: color1, colorBottom: color2)
        cell.titleText.text = titles[indexPath.row]
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: ((collectionView.frame.width / 2) - 10)  , height: ((collectionView.frame.height / 3) - 10))
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        print("hello")
        let cell = collectionView.cellForItem(at: indexPath) as! TraningCell ;
        let vc = storyboard?.instantiateViewController(withIdentifier: "detailtraning") as! DetailTraning
        vc.title = cell.titleText.text
        navigationController?.pushViewController(vc, animated: true)
    }
    

}
